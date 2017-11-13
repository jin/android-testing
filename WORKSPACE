load("@bazel_tools//tools/build_defs/repo:maven_rules.bzl", "maven_aar", "maven_jar")

# git_repository(
#     name = "android_test_support",
#     commit = "3d2d0ae5a029afd486e0916517cb0f5acd90af57",
#     remote = "https://github.com/google/android-testing-support-library.git",
# )

local_repository(
    name = "android_test_support",
    path = "/usr/local/google/home/jingwen/code/android-testing-support-library/",
)

load("@android_test_support//tools/android/emulator:unified_launcher.bzl", "load_workspace")

android_sdk_repository(name = "androidsdk")

android_ndk_repository(name = "androidndk")

maven_aar(
    name = "com_android_support_test_runner",
    artifact = "com.android.support.test:runner:1.0.1",
    settings = "//:settings.xml",
)

maven_aar(
    name = "com_android_support_test_rules",
    artifact = "com.android.support.test:rules:1.0.1",
    settings = "//:settings.xml",
)

maven_aar(
    name = "com_android_support_test_espresso_espresso_core",
    artifact = "com.android.support.test.espresso:espresso-core:3.0.1",
    settings = "//:settings.xml",
)

maven_aar(
    name = "com_android_support_test_espresso_espresso_idling_resource",
    artifact = "com.android.support.test.espresso:espresso-idling-resource:3.0.1",
    settings = "//:settings.xml",
)

maven_jar(
    name = "com_android_support_support_annotations",
    artifact = "com.android.support:support-annotations:25.4.0",
    settings = "//:settings.xml",
)

maven_jar(
    name = "com_google_inject_guice",
    artifact = "com.google.inject:guice:4.0",
)

maven_jar(
    name = "junit_junit",
    artifact = "junit:junit:4.12",
)

maven_jar(
    name = "javax_inject_javax_inject",
    artifact = "javax.inject:javax.inject:1",
)

maven_jar(
    name = "org_hamcrest_java_hamcrest",
    artifact = "org.hamcrest:java-hamcrest:2.0.0.0",
)

maven_jar(
    name = "com_google_guava_guava",
    artifact = "com.google.guava:guava:18.0",
)

load_workspace()
