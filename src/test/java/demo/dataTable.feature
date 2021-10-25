@datatable
Feature: Datatable Feature
    
  @datatable_step
  Scenario Outline: Create new Customer with email <Username>

    When Input to Username and Password
      | Name       | Pass       | 
      | <Username> | <Password> | 
     And Click to Submit button 
  
    Examples: 
      | Username   | Password |
      | 0977108233 | 123456   |
      | 0977108234 | 123456   |
      | 0977108235 | 123456   |
      | 0977108236 | 123456   |
      
   @datatable_scenario @data_driven_testing
 	 Scenario Outline: Data table in Scenario

    When Input to Username textbox with "<Username>" 
    And Input to Password textbox with "<Password>" 
    And Click to Submit button 
  
    Examples: 
      | Username   | Password |
      | 0977108233 | 123456   |
      | 0932088445 | 123456   |

