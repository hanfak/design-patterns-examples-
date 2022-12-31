Here the common duplicated logic has been extracted out into a class and injected into each of the classes. Now we have one place to change the logic

Could have used a static method for such a simple impl, as it is just a function (no side effects), and if testing we dont mind testing the whole class and it's dependency together (ie no mocks). But if share code was more complex, then better adding it as dependency.

Either way, the four classes A,B,C,D are now dependent on the code (coupled) in SharedWorkerImpl. We have minimised this dep by using an interface, to allow us to change which impl to use at runtime (ie when constructor the object can use a factory to inject what impl we want depending on some that can change)

This extraction has pitfalls, due to dep on shared code, if the shared code changes, then all the dependencies are affected