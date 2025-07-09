<img src="logo.png" width="150px">

# Cat Eyes
This is an installable modification for the videogame, Minecraft Java Edition.  
Utilizing Java and some JSON, I created an addition to the game to make it easier for players to navigate poorly lit environments.

### One user wrote:
*"Thank you for such a great mod, I have low vision and mods like this are actually a great accessibility aid because I cannot rely on the monitor gamma..."*  

## Download
View the mod: [CurseForge](https://www.curseforge.com/minecraft/mc-mods/cat-eyes-night-vision-toggle-mod)

## Developer Guide

### To update
- Update the properties from *gradle.properties*. Follow the [Fabric Develop guide](https://fabricmc.net/develop/).
- Increment the mod's version number
- If it's a new Minecraft version, change the version number in */src/main/resources/fabric.mod.json*
- Updating fabric-loom version
  - If a new gradle version is required to update the Loom version:
    - Update the version number in `gradle/gradle-wrapper.properties`
    - Use ```./gradlew wrapper --gradle-version x.x``` (replace `x.x` with the new version number)

### To build
Enter ```./gradlew build``` into the terminal.<br>
The build will appear in the *build/libs* folder

### To release
- Commit changes for the new version
- Navigate to the [release page](https://github.com/Tee-6/Cat_Eyes/releases)
- Create new release
- Create a new tag with the version number
- Upload a file of the mod (same file that's uploaded to CurseForge
