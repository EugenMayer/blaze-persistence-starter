# build

```
./gradlew build -x test

# build info

./gradlew build -x test --info
```

# test

```
./gradlew test
```

## Annotation processor hints

All the messages that can be shown when using `--info` during build are listed
here [messages](https://github.com/gradle/gradle/blob/8173acdb88b1fdaf7a7cda9e583800628ad145fb/subprojects/language-java/src/main/java/org/gradle/api/internal/tasks/compile/incremental/SelectiveCompiler.java)

### Full build scenarios

Can be tracked using `./gradlew build -x test --info | grep Full`

- Changing an `Entity`
- Changing an `EntityView`
- Changing an `Create/Update EntityView`
- Introducing new methods to `Services` e.g. `ProductService`
