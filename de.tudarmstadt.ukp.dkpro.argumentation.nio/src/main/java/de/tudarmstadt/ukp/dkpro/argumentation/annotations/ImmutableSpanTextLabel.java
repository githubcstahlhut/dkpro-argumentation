/*
 * Copyright (c) the Department of Informatics, Technische Universität Darmstadt. All Rights Reserved.
 *
 * Unauthorized distribution of this file via any medium is strictly prohibited.
 */
package de.tudarmstadt.ukp.dkpro.argumentation.annotations;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * @author <a href="mailto:shore@ukp.informatik.tu-darmstadt.de">Todd Shore</a>
 * @since Apr 29, 2016
 *
 */
@JsonPropertyOrder({ ImmutableSpanTextLabel.PROPERTY_TEXT_SPAN, ImmutableSpanTextLabel.PROPERTY_LABEL })
public final class ImmutableSpanTextLabel implements Serializable, SpanTextLabel {

	public static final String PROPERTY_LABEL = "label";

	public static final String PROPERTY_TEXT_SPAN = "textSpan";

	/**
	 *
	 */
	private static final long serialVersionUID = -5564537471325147494L;

	private final transient int hashCode;

	private final String label;

	private final ImmutableSpanText textSpan;

	/**
	 *
	 */
	@JsonCreator
	public ImmutableSpanTextLabel(@JsonProperty(PROPERTY_TEXT_SPAN) final ImmutableSpanText textSpan,
			@JsonProperty(PROPERTY_LABEL) final String label) {
		this.textSpan = textSpan;
		this.label = label;

		hashCode = createHashCode();
	}

	public int createHashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (label == null ? 0 : label.hashCode());
		result = prime * result + (textSpan == null ? 0 : textSpan.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof ImmutableSpanTextLabel)) {
			return false;
		}
		final ImmutableSpanTextLabel other = (ImmutableSpanTextLabel) obj;
		if (label == null) {
			if (other.label != null) {
				return false;
			}
		} else if (!label.equals(other.label)) {
			return false;
		}
		if (textSpan == null) {
			if (other.textSpan != null) {
				return false;
			}
		} else if (!textSpan.equals(other.textSpan)) {
			return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see de.tudarmstadt.ukp.dkpro.argumentation.annotations.SpanAnnotation#
	 * getAnnotationType()
	 */
	// @Override
	/*
	 * (non-Javadoc)
	 * 
	 * @see de.tudarmstadt.ukp.dkpro.argumentation.annotations.LabelledTextSpan#
	 * getLabel()
	 */
	@Override
	@JsonProperty(PROPERTY_LABEL)
	public String getLabel() {
		return label;
	}

	// @Override
	// @JsonProperty(PROPERTY_TEXT_SPAN)
	// public ImmutableSpan getSpan() {
	// return textSpan.getSpan();
	// }

	// @Override
	/*
	 * (non-Javadoc)
	 * 
	 * @see de.tudarmstadt.ukp.dkpro.argumentation.annotations.LabelledTextSpan#
	 * getTextSpan()
	 */
	@Override
	@JsonProperty(PROPERTY_TEXT_SPAN)
	public ImmutableSpanText getTextSpan() {
		return textSpan;
	}

	@Override
	public int hashCode() {
		return hashCode;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		builder.append("ImmutableLabelledTextSpan [getTextSpan()=");
		builder.append(getTextSpan());
		builder.append(", getLabel()=");
		builder.append(getLabel());
		builder.append("]");
		return builder.toString();
	}

}
