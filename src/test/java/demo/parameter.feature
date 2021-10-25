@parameter
Feature: Parameter feature

Background:
  Given Open facebook application
  
	@no_param
  Scenario: Scenario have no parameter
    When Input to Username textbox
    And Input to Password testbox
    And Click to Submit button
    And Close application
   
   @param_mark
   Scenario: Scenario have parameter
    When Input to Username textbox with "0977108233"
    And Input to Password textbox with "123456"
    And Click to Submit button
    And Close application
    
   @param_no_mark
   Scenario: Scenario have parameter
    When Input to Username textbox with 0977108233
    And Input to Password testbox with 123456
    And Click to Submit button
    And Close application
    
   @multiple_param
   Scenario: Scenario have parameter
    When Input to Username with "0977108233" and Password with "123456"
    And Click to Submit button
    And Close application

