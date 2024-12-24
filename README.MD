# AdaptiveStack

Extremely simple Compose Multiplatform Library!

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
