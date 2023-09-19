# KoinUnitTestDemo

In this project, I want to demo how Koin works with UnitTest.

I got a ComponentA, which injects the ComponetB and works inside the App.

```kotlin
val appModule = module {
    factory { ComponentA(get()) }
    factory { ComponentD(get(named("default"))) }
    factory<ComponentInterface> { ComponentB() }
    factory<ComponentInterface>(named("default")) { ComponentB() }
}
```

This definition shows Koin how it should inject the dependency in the [Applications](https://github.com/jastpower884/KoinUnitTestDemo/blob/main/app/src/main/java/com/jastzeonic/koinunittestdemo/KoinUnitTestDemoApplication.kt)


For some reason, I wish ComponentA could use ComponetC in the UnitTest, but ComponetD Still uses ComponentB.

And Here is how it should be:

```kotlin

    private val mockModule = module {
        single<ComponentInterface> { ComponentC() }
    }

    @get:Rule
    val koinTestRule = KoinTestRule.create {
        printLogger()
        modules(appModule, mockModule)
    }

    private val componentA: ComponentA by inject()
    private val componentD: ComponentD by inject()

```

You can check it in [ExampleUnitTest](https://github.com/jastpower884/KoinUnitTestDemo/blob/main/app/src/test/java/com/jastzeonic/koinunittestdemo/ExampleUnitTest.kt), which extends the test class that KoinTest must extend if you want to use Koin in a unit test. You can see that the mockModule overrides the appModule, and it works as I expected.