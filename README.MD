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

## License
```
MIT License

Copyright (c) 2024 Konstantin Tskhovrebov (@terrakok)

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```