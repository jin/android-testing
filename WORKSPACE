# Use johnynek/bazel-deps to generate Maven dependencies
load("//3rdparty:workspace.bzl", "maven_dependencies")
load("@bazel_tools//tools/build_defs/repo:maven_rules.bzl", "maven_aar")

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

maven_dependencies()

android_sdk_repository(name = "androidsdk")

android_ndk_repository(name = "androidndk")

maven_aar(
    name = "com_android_support_test_runner",
    artifact = "com.android.support.test:runner:1.0.0",
    settings = "//:settings.xml",
)

maven_aar(
    name = "com_android_support_test_rules",
    artifact = "com.android.support.test:rules:1.0.0",
    settings = "//:settings.xml",
)

maven_aar(
    name = "com_android_support_test_espresso_espresso_core",
    artifact = "com.android.support.test.espresso:espresso-core:3.0.0",
    settings = "//:settings.xml",
)

maven_aar(
    name = "com_android_support_test_espresso_espresso_idling_resource",
    artifact = "com.android.support.test.espresso:espresso-idling-resource:3.0.0",
    settings = "//:settings.xml",
)

load_workspace()
