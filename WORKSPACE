# Use johnynek/bazel-deps to generate Maven dependencies
load("//3rdparty:workspace.bzl", "maven_dependencies")
load("@bazel_tools//tools/build_defs/repo:maven_rules.bzl", "maven_aar")

maven_dependencies()

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
