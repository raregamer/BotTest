
	import java.io.FileOutputStream;
	import java.io.IOException;
	import java.io.PrintStream;

	import org.jsoup.Jsoup;
	import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

	// This class is used for HTML parsing from URL using Jsoup.



	public class CraigslistParse {

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			
			print("Running...");
			Document document;
			
			try {
				//get document object after parsing the html from given url.
				document = Jsoup.connect("https://lasvegas.craigslist.org/d/video-gaming/search/vga").get();
				
				String title = document.title(); //get title
				print(" Title: " + title); //print title
//				Elements price = document.select("span[class=result-price]"); //get price
				Elements links = document.select("a[href]:contains(xbox)");
				
				for(Element link : links) {
					System.out.println("HREF: " + link.attr("href"));
					print("Text: " + link.text());
					print(link.select(".result-price").text());
			
				}
				

			}catch (IOException e) {
				e.printStackTrace();
			}
			
			print("Done");

		}
		
		public static void print(String string) {
			System.out.println(string);
		}

	}

	
