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

import java.util.Objects;

/**
 * A simple class to define a version number.
 */
final class Version {

	/**
	 * The major part of the version number.
	 */
	private final int major;

	/**
	 * Create the version.
	 *
	 * @param major The major part of the version.
	 */
	Version(int major) {
		this.major = major;
	}

	/**
	 * Get {@link #major}
	 *
	 * @return {@link #major}
	 */
	int getMajor() {
		return major;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}

		if (o instanceof Version) {
			Version v = (Version) o;
			return v.major == major;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(major);
	}

	@Override
	public String toString() {
		return "Version{major=" + major + "}";
	}
}
