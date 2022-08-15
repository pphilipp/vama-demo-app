# vama-demo-app

This is a master-details sample codebase. 

- single-activity codebase
- clean architecure (data/domain/presentation)
- MVVM architecture of presentation layer
- 'mappers/models per layer'strategy between layers for preventing a tight coupling
- multythreading by coroutines and flow
- Room database for persisting data locally
- Retrofit extantion to OkHttpClient for networking proccesing
- MotionLayout for animating a toolbar by scrolling a liust (it was experiment for me)
- Navigation library with save arguments for transfering data between screens
- design system base line for extendability UI elements
- 'Single source of truth' strategy was accomplished by keeping data locally and observing it from UI. 
