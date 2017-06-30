## Gradle Project Templates for Java 8

This is a repository of project templates that can be copied and then gutted to kickstart a modular project 
and maintain a clean, extensible, best practice structure from the get-go. Currently it focuses on Java 8 projects.

Choose one subdirectory and use the structure and gradle techniques as a project template.

### Common/Shared Techniques
* Every module contains a root *build.gradle* and *settings.gradle* file to set dependencies and other specifics and the module's name.
* Top level `/gradle/` folder: This is where nonstandard build scripts go (e.g. anything not *build.gradle* and *settings.gradle*).
  This folder is exported to a variable in the root build.gradle file, so subprojects can reference "$buildFiles" independent of directory to reuse them.
* Shared external dependencies file ([settings-deps.gradle](flatmodules/gradle/settings-deps.gradle)), this is a way to share referenced 
  dependency versions in submodules without using any gradle plugins.
* Easy and automated top level `/libs/` folder: Some java dependencies are not in maven central, this directory is a dropbox for auto discoverable dependencies.
  The [settings-deps.gradle](flatmodules/gradle/settings-deps.gradle#L63-L67) file exposes each jar dropped in this file as a possible dependency.
* Dependency flexibility (with ease): With the above two techniques combined, you have strong (but simple)
  flexibility in [how you can reference dependencies](flatmodules/modules/app-simpleapp/build.gradle#L5-L15), whether another project, flat jar, maven, etc.
* Shared ([settings-java.gradle](flatmodules/gradle/settings-java.gradle)) file for java configuration. This makes any java module's build.gradle file
  [extremely small](flatmodules/modules/app-simpleapp/build.gradle#L1), as they can share java config. Sweeping project changes go in the shared file, and
  module specific granularity changes can go in the module's build.gradle file (yay no repetition!).
* Shared [repositories](flatmodules/gradle/settings-repos.gradle) declaration. It's 99.9% of the time this is a whole project on-or-off mechanism, so extract it.


### [Flat Modules Structure](flatmodules/)

This structure is similar to Gradle's own multiproject repo grouping submodules in one top level 'modules' directory, outside of 
which there is no project related code. All actual project source code that is not buildscripts or config must go in this 
directory in an appropriate module.

### [Hierarchical Structure](hierarchical/)

This structure uses the same idea of module grouping, but has multiple root submodule folders (currently `/apps` and `/core`).

If you have a particularly large project/repository, grouping them by layer like this (e.g. `/db`, `/core`, `/services`, `/site`) and then 
modules within may become necessary, and this structure excels at this.
