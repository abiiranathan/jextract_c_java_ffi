
#include "math.h"

double add(double a, double b) {
    return a + b;
}

double subtract(double a, double b) {
    return a - b;
}

double multiply(double a, double b) {
    return a * b;
}

double divide(double a, double b) {
    return a / b;
}

long factorial(int n) {
    int i;
    long result = 1;
    for (i = 1; i <= n; i++) {
        result *= i;
    }
    return result;
}