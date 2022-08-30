package org.generation.blog_pessoal.model;

import javax.persistence.GenerationType;

public @interface GeratedValue {

	GenerationType strategy();

}
