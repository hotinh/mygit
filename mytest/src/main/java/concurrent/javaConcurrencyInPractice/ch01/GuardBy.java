package concurrent.javaConcurrencyInPractice.ch01;

public @interface GuardBy {
    String value() default "";
}
