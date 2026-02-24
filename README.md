# Quantity Measurement Application

A comprehensive Java-based application for handling various quantity measurements with support for length, weight, volume, and arithmetic operations across different units.

## Project Overview

This application provides a robust framework for converting, comparing, and performing arithmetic operations on different measurement units. Built using Test-Driven Development (TDD) principles, each feature has been incrementally developed through dedicated feature branches.

## Features Implemented

### UC1: Feet Equality
**Branch:** `feature/UC1-FeetEquality`
- Implemented basic equality comparison for feet measurements
- Established foundational test cases for length measurements
- Created initial project structure and Length class

### UC2: Inch Equality
**Branch:** `feature/UC2-InchEquality`
- Added support for inch measurements
- Implemented equality comparison for inches
- Extended test coverage for multiple length units

### UC3: Generic Length
**Branch:** `feature/UC3-GenericLength`
- Refactored code to support generic length measurements
- Created a unified approach for handling different length units
- Improved code maintainability and extensibility

### UC4: Yard Equality
**Branch:** `feature/UC4-YardEquality`
- Added support for yard measurements
- Implemented equality comparison for yards
- Expanded length measurement capabilities

### UC5: Unit Conversion
**Branch:** `feature/UC5-UnitConversion`
- Implemented conversion logic between different length units
- Added support for feet to inches, yards to feet, etc.
- Enhanced measurement comparison accuracy

### UC6: Unit Addition
**Branch:** `feature/UC6-UnitAddition`
- Implemented addition operations for same-unit measurements
- Created arithmetic operation framework
- Added test cases for addition functionality

### UC7: Target Unit Addition
**Branch:** `feature/UC7-TargetUnitAddition`
- Enhanced addition to support cross-unit operations
- Implemented result conversion to target units
- Added flexibility in arithmetic operations

### UC8: Standalone Unit
**Branch:** `feature/UC8-StandaloneUnit`
- Refactored unit handling to create standalone unit classes
- Improved separation of concerns
- Enhanced code organization and reusability

### UC9: Weight Measurement
**Branch:** `feature/UC9-Weight-Measurement`
- Added support for weight measurements
- Implemented grams, kilograms, and tons
- Extended the application beyond length measurements

### UC10: Unit Interface for Multi-Category Support
**Branch:** `feature/UC10-Unit-Interface-For-MultiCategory-Support`
- Created a generic Unit interface
- Enabled support for multiple measurement categories (length, weight, volume)
- Implemented polymorphic behavior for different unit types

### UC11: Volume Measurement Equality
**Branch:** `feature/UC11-Volume-Measurement-Equality`
- Added support for volume measurements
- Implemented liters, gallons, and milliliters
- Extended equality comparison to volume units

### UC12: Subtraction and Division
**Branch:** `feature/UC12-Subtraction-and-Division`
- Implemented subtraction operations for measurements
- Added division functionality
- Completed basic arithmetic operation suite

### UC13: Centralized Arithmetic Logic
**Branch:** `feature/UC13-Centralized-Arithmetic-Logic`
- Refactored arithmetic operations into centralized logic
- Improved code maintainability and reduced duplication
- Created a unified arithmetic handler for all operations

## Technology Stack

- **Language:** Java
- **Testing:** JUnit
- **Build Tool:** Gradle
- **Development Approach:** Test-Driven Development (TDD)

## Development Methodology

This project follows a feature-branch workflow where each use case (UC) is developed in isolation:
1. Create a feature branch for the use case
2. Write failing tests
3. Implement the feature to pass tests
4. Refactor code for quality
5. Merge to dev branch after testing

## Current Status

✅ All 13 use cases have been successfully implemented and tested
✅ Code has been refactored for optimal design
✅ Comprehensive test coverage across all features
✅ Ready for integration and deployment

## Branch Structure

- `main` - Production-ready code
- `dev` - Integration branch for all features
- `feature/UC[1-13]-*` - Individual feature branches for each use case

---

**Author:** Shivam Pal  
**Last Updated:** 2026-02-24 05:48:39