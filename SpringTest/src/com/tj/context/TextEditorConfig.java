package com.tj.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TextEditorConfig {

	@Bean
	public TextEditor textEditor() {
		TextEditor a = new TextEditor();
		a.setSpellChecker(spellChecker());
		return a;
	}
	
	@Bean
	public SpellChecker spellChecker() {
		return new SpellChecker();
	}
}
