# AdaptiveStack

Extremely simple Compose Multiplatform Library!

https://github.com/user-attachments/assets/0a932492-84af-4cd0-a286-7ea2a3e6140b

```kotlin
HorizontalAdaptiveStack(
   modifier = Modifier.fillMaxSize().padding(8.dp),
) {
   VerticalAdaptiveStack {
      repeat(5) {
         Box(
            Modifier
               .size(40.dp)
               .padding(8.dp)
               .background(MaterialTheme.colorScheme.primary)
         )
      }
   }
   HorizontalAdaptiveStack {
      repeat(3) {
         Box(
            Modifier
               .weight(1f)
               .padding(8.dp)
               .fillMaxSize()
               .background(MaterialTheme.colorScheme.secondary)
         )
      }
   }
}
```

### Add dependency
Latest version: [![Maven Central](https://img.shields.io/maven-central/v/com.github.terrakok/adaptivestack)](https://central.sonatype.com/artifact/com.github.terrakok/adaptivestack)

```kotlin
dependencies {
    implementation("com.github.terrakok:adaptivestack:_version_")
}
```