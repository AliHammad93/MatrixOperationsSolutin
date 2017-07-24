package com.progressoft.utilities;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class MatrixOperationsUtilityTest {

	private MatrixOperationsUtility matrixOperationsUtility;

	@Before
	public void setup() {

		// dummy implementation, to be replaced
		matrixOperationsUtility = new MatrixOperationsUtility() {
    @Override
    public int[][] add(int[][] a, int[][] b) throws IncompatibleArgumentsException {
        int[][] result = new int[a.length][a[0].length];

        if (a.length == b.length && a[0].length == b[0].length) {
            for (int i = 0; i < a.length; i++) {
                {
                    for (int j = 0; j < a[i].length; j++) {

                        result[i][j] = a[i][j] + b[i][j];
                    }

                }
            }
            return result;

        }

        throw new IncompatibleArgumentsException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    @Override
    public int[][] scalarMultiply(int scalar, int[][] a) {

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = a[i][j] * scalar;

            }
        }
        return a;

    }

    @Override
    public int[][] transport(int[][] a) {
        
        int[][] result = new int[a[0].length][a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                result[j][i] = a[i][j];
            }
        }
        return result;
    }

    @Override
    public int[][] multiply(int[][] a, int[][] b) throws IncompatibleArgumentsException {
        if (a[0].length != b.length) {

            throw new IncompatibleArgumentsException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        } else {

            int multiply[][] = new int[a.length][b[0].length];
            int sum = 0;
            for (int c = 0; c < a.length; c++) {
                for (int d = 0; d < b[0].length; d++) {
                    for (int k = 0; k < b.length; k++) {
                        sum = sum + a[c][k] * b[k][d];
                    }

                    multiply[c][d] = sum;
                    sum = 0;
                }
            }
            return multiply;

        }
    }

                };
                        }

	@Test
	public void givenMathematicalMatrixOperationsModel_CallingAddMethod_PassingSameSizeMatrices_Case1_ShouldReutrnTheExpectedResults() {
		int firstMatrix[][] = { { 1, 4, 7 } };
		int secondMatrix[][] = { { 9, 6, 3 } };
		int expectedResults[][] = { { 10, 10, 10 } };
		assertResultsAreEquals(expectedResults, matrixOperationsUtility.add(firstMatrix, secondMatrix));
	}

	@Test
	public void givenMathematicalMatrixOperationsModel_CallingAddMethod_PassingSameSizeMatrices_Case2_ShouldReutrnTheExpectedResults() {
		int firstMatrix[][] = { { 1 }, { 4 }, { 7 } };
		int secondMatrix[][] = { { 9 }, { 6 }, { 3 } };
		int expectedResults[][] = { { 10 }, { 10 }, { 10 } };
		int returnedResults[][] = matrixOperationsUtility.add(firstMatrix, secondMatrix);
		assertResultsAreEquals(expectedResults, returnedResults);
	}

	@Test(expected = IncompatibleArgumentsException.class)
	public void givenMathematicalMatrixOperationsModel_CallingAddMethod_PassingNonEqualsSizesMatrices_ShouldThrowIncompatibleArguments() {
		int firstMatrix[][] = new int[1][3];
		int secondMatrix[][] = new int[3][3];
		matrixOperationsUtility.add(firstMatrix, secondMatrix);
	}

	@Test
	public void givenMathematicalMatrixOperationsModel_CallingScalarMultiply_PassingValidMatrix_ShouldReutrnTheExpectedResults() {
		int matrix[][] = { { 1, 2, 3 } };
		int scaler = 2;
		int expectedResults[][] = { { 2, 4, 6 } };
		assertResultsAreEquals(expectedResults, matrixOperationsUtility.scalarMultiply(scaler, matrix));
	}

	@Test
	public void givenMathematicalMatrixOperationsModel_CallingScalarMultiply_PassingZeroSizeMatrix_ShouldReutrnTheExpectedResults() {
		int matrix[][] = new int[0][0];
		int scaler = 2;
		int expectedResults[][] = new int[0][0];
		assertResultsAreEquals(expectedResults, matrixOperationsUtility.scalarMultiply(scaler, matrix));
	}

	@Test(expected = Exception.class)
	public void givenMathematicalMatrixOperationsModel_CallingTranport_PassingNullMatrix_ShouldThrowAnException() {
		matrixOperationsUtility.transport(null);
	}

	@Test
	public void givenMathematicalMatrixOperationsModel_CallingTranport_PassingValidMatrix_Case1_ShouldReutrnTheExpectedResults() {
		int matrix[][] = { { 1 } };
		int expectedResults[][] = { { 1 } };
		assertResultsAreEquals(expectedResults, matrixOperationsUtility.transport(matrix));
	}

	@Test
	public void givenMathematicalMatrixOperationsModel_CallingTranport_PassingValidMatrix_Case2_ShouldReutrnTheExpectedResults() {
		int matrix[][] = { { 1, 2, 3 }, { 1, 2, 3 } };
		int expectedResults[][] = { { 1, 1 }, { 2, 2 }, { 3, 3 } };
		assertResultsAreEquals(expectedResults, matrixOperationsUtility.transport(matrix));
	}

	@Test(expected = Exception.class)
	public void givenMatheMaticalMatrixOperationsMoldel_CallingMultiply_PassingFirstMatrixWithDifferentRowsLengths_ShouldThrowAnException() {
		int firstMatrix[][] = { { 1, 2 }, { 1, 2, 3 } };
		int secondMatrix[][] = new int[2][2];
		matrixOperationsUtility.multiply(firstMatrix, secondMatrix);
	}

	@Test(expected = IncompatibleArgumentsException.class)
	public void givenMatheMaticalMatrixOperationsMoldel_CallingMultiply_PassingFirstMatrixWithZeroRows_ShouldThrowIncompatibleArguments() {
		int firstMatrix[][] = new int[0][1];
		int secondMatrix[][] = new int[2][2];
		matrixOperationsUtility.multiply(firstMatrix, secondMatrix);
	}

	@Test
	public void givenMatheMaticalMatrixOperationsMoldel_CallingMultiply_PassingValidMatrices_ShouldReturnTheExpectedResult() {
		int firstMatrix[][] = { { 1, 2, 3 }, { 1, 2, 3 } };
		int secondMatrix[][] = { { 3, 3 }, { 2, 2 }, { 1, 1 } };
		int expectedResult[][] = { { 10, 10 }, { 10, 10 } };
		assertResultsAreEquals(expectedResult, matrixOperationsUtility.multiply(firstMatrix, secondMatrix));
	}

	private void assertResultsAreEquals(int[][] expectedResults, int[][] returnedResults) {
		assertEquals(expectedResults.length, returnedResults.length);
		for (int i = 0; i < expectedResults.length; ++i) {
			assertArrayEquals(expectedResults[i], returnedResults[i]);
		}
	}

}
