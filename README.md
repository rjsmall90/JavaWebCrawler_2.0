# JavaWebCrawler 2.0
I have an full-stack application idea that involves, in part, the usage of a web crawler. I'm building a crawler command-line application to analyze how it could function within the greater context.  

Using Java, Maven, & Apache HttpClient for the connection - Building an upgraded web crawler that given a keyword can locate and collect links, and excerpts
where instances of the keyword appear, and print out to a text file. 

## What I Did Differently
Using Apache HttpClient allows me to build out the connection process manually and make my own GET & POST requests as needed. This way I can see exactly what info I'm requesting and manipulate 
it more freely than with JSoup. 
It uses string match in order to locate a word amongst 

## How To Use
 Enter url in console. 
 
 Next the application will prompt you to enter in targeted string.
 
 A seperate text file will generate with excerpts of targeted string with 50 characters before and 
 150 characters leading as well as a count of how many times the string was found. 




 #### Mon, March 2nd 2020
•Read further documentation on Apache Http Client

•Looked into difference between DefaultHttpClient v CloseableHttpClient

•Modified HttpResponse to *CloseableHttpResponse* 

•Target url updated to reflect impact of recent changes
 
 
