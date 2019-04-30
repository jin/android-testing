load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")
load("@bazel_tools//tools/build_defs/repo:jvm.bzl", "jvm_maven_import_external")

# Set the path to your local SDK installation, or use the ANDROID_HOME environment variable.
android_sdk_repository(
    name="androidsdk",
    api_level=28,
    build_tools_version="28.0.2",
)

android_ndk_repository(
    name="androidndk"
)

# Android Test Support
#
# This repository contains the supporting tools to run Android instrumentation tests,
# like the emulator definitions (android_device) and the device broker/test runner.
ATS_TAG = "androidx-test-1.1.1-alpha01"

ATS_SHA256 = "f7e967cb471bc279fda564084e965868d96e6c608fa27e26cf4330ae29cd603e"

http_archive(
    name = "android_test_support",
    sha256 = ATS_SHA256,
    strip_prefix = "android-test-%s" % ATS_TAG,
    urls = ["https://github.com/android/android-test/archive/%s.tar.gz" % ATS_TAG],
)

load("@android_test_support//:repo.bzl", "android_test_repositories")

android_test_repositories()

load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")
RULES_JVM_EXTERNAL_TAG = "1.2"
RULES_JVM_EXTERNAL_SHA = "e5c68b87f750309a79f59c2b69ead5c3221ffa54ff9496306937bfa1c9c8c86b"

http_archive(
    name = "rules_jvm_external",
    strip_prefix = "rules_jvm_external-%s" % RULES_JVM_EXTERNAL_TAG,
    sha256 = RULES_JVM_EXTERNAL_SHA,
    url = "https://github.com/bazelbuild/rules_jvm_external/archive/%s.zip" % RULES_JVM_EXTERNAL_TAG,
)
# Keeping a copy of gmaven_rules around so dependencies can use it
# TODO(jin): remove this when android/android-test no longer depends on gmaven_rules.
http_archive(
    name = "gmaven_rules",
    sha256 = RULES_JVM_EXTERNAL_SHA,
    strip_prefix = "rules_jvm_external-%s" % RULES_JVM_EXTERNAL_TAG,
    url = "https://github.com/bazelbuild/rules_jvm_external/archive/%s.zip" % RULES_JVM_EXTERNAL_TAG,
)

load("@rules_jvm_external//:defs.bzl", "maven_install")
load(
    "//:common_defs.bzl",
    "androidxLibVersion",
    "coreVersion",
    "espressoVersion",
    "extJUnitVersion",
    "extTruthVersion",
    "rulesVersion",
    "runnerVersion",
    "uiAutomatorVersion",
)

maven_install(
    name = "maven",
    artifacts = [
        "androidx.annotation:annotation:" + androidxLibVersion,
        "androidx.core:core:" + androidxLibVersion,
        "androidx.recyclerview:recyclerview:" + androidxLibVersion,
        "androidx.test:core:" + coreVersion,
        "androidx.test.espresso:espresso-contrib:" + espressoVersion,
        "androidx.test.espresso:espresso-core:" + espressoVersion,
        "androidx.test.espresso:espresso-idling-resource:" + espressoVersion,
        "androidx.test.espresso:espresso-intents:" + espressoVersion,
        "androidx.test.ext:junit:" + extJUnitVersion,
        "androidx.test.ext:truth:" + extTruthVersion,
        "androidx.test:monitor:" + runnerVersion,
        "androidx.test:rules:" + rulesVersion,
        "androidx.test:runner:" + runnerVersion,
        "androidx.test.uiautomator:uiautomator:" + uiAutomatorVersion,
        "com.google.inject:guice:4.0",
        "junit:junit:4.12",
        "javax.inject:javax.inject:1",
        "org.hamcrest:java-hamcrest:2.0.0.0",
        "com.google.guava:guava:26.0-android",
        "com.google.truth:truth:0.42",
    ],
    repositories = [
        "https://maven.google.com",
        "https://repo1.maven.org/maven2",
    ],
)

local_repository(
    name = "bazel_toolchains",
    path = "/usr/local/google/home/jingwen/code/bazel-toolchains",
)

# http_archive(
#     name = "bazel_toolchains",
#     sha256 = "4b1468b254a572dbe134cc1fd7c6eab1618a72acd339749ea343bd8f55c3b7eb",
#     strip_prefix = "bazel-toolchains-d665ccfa3e9c90fa789671bf4ef5f7c19c5715c4",
#     urls = [
#         "https://mirror.bazel.build/github.com/bazelbuild/bazel-toolchains/archive/d665ccfa3e9c90fa789671bf4ef5f7c19c5715c4.tar.gz",
#         "https://github.com/bazelbuild/bazel-toolchains/archive/d665ccfa3e9c90fa789671bf4ef5f7c19c5715c4.tar.gz",
#     ],
# )

register_execution_platforms(":android_platform")
