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

package com.github.mjeanroy.junit4.runif.conditions;

/**
 * Static Java Utilities.
 */
final class JavaUtils {

	/**
	 * The system property name for the java specification version.
	 */
	private static final String JAVA_SPECIFICATION_VERSION_PROP = "java.specification.version";

	// Ensure non instantiation.
	private JavaUtils() {
	}

	/**
	 * Get the Java Specification Version.
	 *
	 * @return The java specification version, as a {@link String}.
	 */
	static Version getJavaSpecificationVersion() {
		String version = getSystemProperty("java.specification.version");
		return parseVersion(version);
	}

	/**
	 * Parse Java version number.
	 *
	 * @param version The version number.
	 * @return The version.
	 */
	private static Version parseVersion(String version) {
		String[] parts = version.split("\\.");
		int nbParts = parts.length;
		int majorIndex = nbParts > 1 ? 1 : 0;
		int major = Integer.parseInt(parts[majorIndex]);
		return new Version(major);
	}

	/**
	 * Gets a System property, and throw {@link SystemPropertyReadingException} if system property cannot
	 * be read.
	 *
	 * @param property the system property name
	 * @return the system property value.
	 * @throws SystemPropertyReadingException If the property cannot be read.
	 */
	private static String getSystemProperty(String property) {
		try {
			return System.getProperty(property);
		} catch (SecurityException ex) {
			throw new SystemPropertyReadingException(ex, property);
		}
	}
}
