# To do list

### General

- [ ] Add and example with TypeAdapters?
- [ ] Exchange GSON for Moshi?
- [ ] Implement default Firebase Analytics events.
- [x] Navigation component should be used to navigate instead of manually pushing/popping fragments.
- [x] Exchange deprecated Kotlin extensions for Android view binding.
- [x] Add Crashlytics to the project.
- [x] Add Firebase to the project.
- [x] Migrate from RxJava 2 to RxJava 3.
- [x] Use complete Java 8 API adding desugaring.
- [x] Fix possible memory leak caused by the exit snack bar.
- [x] Abstract navigation to a single view model that is injected in every fragment. Do not use data view models to navigate.
- [x] Finish session token refresh implementation.
- [x] Clear Glide cache on signout.
- [x] Fix data store interface problem. It forces a given implementation to implement functions that will never be used (use iOS template variant?). Besides, tests should be also modified, because they test problems with functions that should not be called depending on the type. The best solution is not to be able to call a function that should not be there.
- [x] Remove any hardcoded dimensions.
- [x] Add error management with retries.
- [x] Add a common events view model starting with authentication error.
- [x] Display loading with a generic loading view instead of a progress bar.
- [x] Add form validators and improve styles.
- [x] Add sign in feature.
- [x] Add bottom navigation example.
- [x] Add navigation drawer example.
- [x] Add a selection screen for choosing navigation template. Add a navigator object.
- [x] Add a splash screen.
- [x] Revise resource state management.
- [x] Move initialization methods in lifecycle methods to a base fragment.
- [x] Make instrumental tests work again.
- [x] Add back icon to tool bar with navigation drawer.
- [x] Add detail view and implement navigation.
- [x] Add fragment switching.
- [x] Use double back to quit app.
- [x] Add navigation drawer.
- [x] Build a shared models package.
- [x] Split data package into data and domain.
- [x] Rename packages and app id to com.company.mobile.android.appname.
- [x] Rename framework package to data sources.
- [x] Rename mobile-ui to app.
- [x] Merge cache and remote packages.
- [x] Convert remote Java library into Android Java library.
- [x] Fix use cases implementation.
- [x] Fix cache behavior.

### Code

- [x] Fix warnings.
- [x] Apply code style to the whole project.

### Setup documentation

- [x] Add code style.
- [x] Add TODO file.
- [x] Add CHANGELOG file.

### Update dependencies

- [x] Add Leak Canary memory leak detection library.
- [x] Update project to Koin 2.0.
- [x] Migrate template from Android support to AndroidX.
- [x] Update all dependencies.
- [x] Add plugin for updating dependencies.
- [x] Fork template.