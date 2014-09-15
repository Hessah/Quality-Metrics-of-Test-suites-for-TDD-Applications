Scenario:  Story index is retrieved from Redmine

When index is retrieved from Redmine at http://demo.redmine.org/projects/jbehave-rest/wiki
Then the index is not empty

Scenario:  Story is loaded from Redmine

When story A_story is loaded from Redmine 
Then story contains title 'A story'
When story Another_story is loaded from Redmine 
Then story contains title 'Another story'

Scenario:  Story is uplaoded to Redmin

When story A_story is uploaded to Redmine
