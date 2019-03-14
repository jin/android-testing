FROM gcr.io/cloud-marketplace/google/rbe-ubuntu16-04@sha256:da0f21c71abce3bbb92c3a0c44c3737f007a82b60f8bd2930abc55fe64fc2729
RUN dpkg --add-architecture i386
RUN apt-get update

# Unified Launcher system dependencies
RUN yes | apt-get install -y \
  cpio \
  xvfb \
  libgl1-mesa-glx \
  libpulse-dev \
  qemu-kvm \
  lsof

# 32-bit dexdump_annotations system dependencies. Required by the android_instrumentation_test runner.
# ldd /tmp/dexdump_annotations
# linux-gate.so.1 =>  (0xf7f05000)
# libpthread.so.0 => /lib/i386-linux-gnu/libpthread.so.0 (0xf7edc000)
# libz.so.1 => not found
# libstdc++.so.6 => not found
# libm.so.6 => /lib/i386-linux-gnu/libm.so.6 (0xf7e87000)
# libgcc_s.so.1 => /lib/i386-linux-gnu/libgcc_s.so.1 (0xf7e69000)
# libc.so.6 => /lib/i386-linux-gnu/libc.so.6 (0xf7cb3000)
# /lib/ld-linux.so.2 (0xf7f07000)
RUN yes | apt-get install -y \
  libc6:i386 \
  libstdc++6:i386 \
  zlib1g:i386
