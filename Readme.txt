POST API Sample:
URL : http://<IP>/api/v1/profile/
Body : {
           "email":"rashi@gmail.com",
           "firstName":"rashi",
           "lastName":"tayal",
           "dateOfBirth":"1994-09-11",
           "gender":"female",
           "likesList":[{
               "subCategory":{
                   "name":"icecream",
                   "category":{
                   "name":"food"
               }
               }
           },
           {
                   "category":{
                   "name":"gadgets"
               }
           }
           ],
           "dislikesList":[{
               "subCategory":{
                   "name":"cakes",
                   "category":{
                   "name":"food"
               }
               }
           }]
       }

PUT API Sample :
URL : http://<IP>/api/v1/profile/P-1
Body : {
           "email":"rashi@gmail.com",
           "firstName":"rashi",
           "lastName":"tayal",
           "dateOfBirth":"1994-09-11",
           "gender":"female",
           "likesList":[{
               "id":31,
               "subCategory":{
                   "name":"icecream",
                   "category":{
                   "name":"food"
               }
               }
           },
           {
                   "id":32,
                   "category":{
                   "name":"flowers"
               }
           },
           {
               "subCategory":{
                   "name":"ethnic",
                   "category":{
                   "name":"clothing"
               }
               }
           }
           ],
           "dislikesList":null
       }

Get API Sample :
URL : http://<IP>/api/v1/profile/rashi@gmail.com

Delete API Sample :
URL : http://<IP>/api/v1/profile/P-1
