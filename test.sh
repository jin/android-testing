set -ex

../bazel/bazel-bin/src/bazel build ui/espresso/BasicSample ui/espresso/BasicSample:BasicSampleTest

adb shell pm uninstall com.example.android.testing.espresso.BasicSample.test
adb shell pm uninstall com.example.android.testing.espresso.BasicSample

adb install bazel-bin/ui/espresso/BasicSample/BasicSample.apk
adb install bazel-bin/ui/espresso/BasicSample/BasicSampleTest.apk

adb shell am instrument com.example.android.testing.espresso.BasicSample.test/android.support.test.runner.AndroidJUnitRunner
