package shareCrawl.naver;

import java.io.IOException;
import java.util.List;

import javax.swing.plaf.synth.SynthSliderUI;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

import shareCrawl.common.HttpsAvoid;

public class GatherShare {
	
	/**
	 * @param args
	 */
	public static void main(String[]args) {
		
		HttpsAvoid ha = new HttpsAvoid();
		ha.toString();
		
		NaverConnect nc = new NaverConnect();
		String naver1 = nc.getNaver1();
		
		try {
			Document doc = Jsoup.connect(naver1).get();
			
			
			Elements thead = doc.getElementsByTag("thead");
			
			
			
			//타이틀
			String title ="";
			String[] titleSplit;
			for(Element el : thead) {
				title=el.getElementsByTag("th").text();
			}
			
			System.out.println(title);
			titleSplit=title.split(" ");
			for(int i=0;i<titleSplit.length;i++) {
				System.out.println(titleSplit[i]);
			}
			
			
			//본내용
			Element tbody = doc.getElementsByTag("tbody").get(1);
			
			System.out.println(tbody);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
	}
	
	
	
}
