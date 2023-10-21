#include <jni.h>
#include "com_litongjava_Print.h"
#include <iostream>

JNIEXPORT void JNICALL Java_com_litongjava_Print_print(JNIEnv *, jobject) {
    std::cout << "Hello from C!" << std::endl;
}