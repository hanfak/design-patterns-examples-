Pub-Sub pattern is very similar to Observer pattern

Differences:
    - Observer pattern, the observers are aware of the observables.
    - Publisher-Subscriber pattern the publishers and subscribers don’t need to know each other.
And 
    - Observer pattern is mostly implemented in a synchronous way i.e. the observable calls the appropriate method of all its observers when some event occurs.
    - Publisher-Subscriber pattern is mostly implemented in an asynchronous way (using message queue).
