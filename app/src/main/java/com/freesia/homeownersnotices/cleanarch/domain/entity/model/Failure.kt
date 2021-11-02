package com.freesia.homeownersnotices.cleanarch.domain.entity.model

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