/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2018 Mickael Jeanroy
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.github.mjeanroy.junit4.runif.tests;

import org.apache.commons.lang3.reflect.FieldUtils;

/**
 * Static Reflection Utilities (used in unit test only).
 */
public final class ReflectionTestUtils {

	// Ensure non instantiation.
	private ReflectionTestUtils() {
	}

	/**
	 * Read private field on given target instance.
	 *
	 * @param target The target instance.
	 * @param fieldName The field name to read.
	 * @param <T> Type of value stored in field name.
	 * @return The field value.
	 */
	@SuppressWarnings("unchecked")
	public static <T> T readField(Object target, String fieldName) {
		try {
			return (T) FieldUtils.readDeclaredField(target, fieldName, true);
		} catch (Exception ex) {
			throw new AssertionError(ex);
		}
	}
}
