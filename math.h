#ifndef MATH_H
#define MATH_H

#ifdef __cplusplus
extern "C" {
#endif

extern double add(double a, double b);
extern double subtract(double a, double b);
extern double multiply(double a, double b);
extern double divide(double a, double b);

extern long factorial(int n);

#ifdef __cplusplus
}
#endif

#endif  // MATH_H