package ga.mr838wind.checkNovel.check;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CheckService {

    public static final String EL_SELECTOR_230BOOK = "div.synopsisArea_detail p:gt(3)";
    public static final String EL_SELECTOR_BIQUGEXS = "div.cover div.block_txt2 p:gt(5)";

    public List<NovelVO> checkAll() throws Exception  {
        List<NovelVO> checkList = initNovelCheckList();

        for(NovelVO item : checkList) {
            this.checkOne(item);
        }
        return checkList;
    }

    private List<NovelVO> initNovelCheckList() {
        List<NovelVO> checkList = new ArrayList<>();

        checkList.add(new NovelVO(1, "仙狐",
                "https://m.230book.com/book/26029/",
                EL_SELECTOR_230BOOK
        ));

        checkList.add(new NovelVO(2, "天阿降临",
                "https://m.230book.com/book/154/",
                EL_SELECTOR_230BOOK));

        checkList.add(new NovelVO(3, "基因大时代",
                "https://m.230book.com/book/16656/",
                EL_SELECTOR_230BOOK));


        return checkList;
    }

    private void checkOne(NovelVO vo) throws Exception {
        Document doc = Jsoup.connect(vo.getUrl()).get();
        Elements element = doc.select(vo.getElSelector());
        vo.setResultHtml(element.outerHtml());
    }

}
