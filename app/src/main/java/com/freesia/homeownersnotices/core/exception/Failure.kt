package com.freesia.homeownersnotices.core.exception

/**
 * Base Class for handling errors/failures/exceptions.
 * Every feature specific failure should extend [Feature] class.
 */
sealed class Failure {
    object NetworkConnection : Failure()
    object ServerError : Failure()
    object Unauthorized : Failure()
    object TokenFullyExpired : Failure()

    /** * Extend this class for feature specific failures.*/
    abstract class Feature: Failure()
}