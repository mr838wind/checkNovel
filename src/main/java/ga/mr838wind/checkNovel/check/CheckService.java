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

        //
        NovelVO vo = new NovelVO(1, "武谪仙",
                "https://m.230book.com/book/14876/",
                EL_SELECTOR_230BOOK);
        checkList.add(vo);

        NovelVO vo2 = new NovelVO(2, "武谪仙",
                "http://m.biqugexs.com/34_34282/",
                EL_SELECTOR_BIQUGEXS);
        checkList.add(vo2);

        //
        NovelVO vo3 = new NovelVO(3, "天阿降临",
                "https://m.230book.com/book/154/",
                EL_SELECTOR_230BOOK);
        checkList.add(vo3);

        NovelVO vo4 = new NovelVO(4, "天阿降临",
                "http://m.biqugexs.com/12_12592/",
                EL_SELECTOR_BIQUGEXS);
        checkList.add(vo4);

        //
        NovelVO vo5 = new NovelVO(5, "沧元图",
                "https://m.230book.com/book/2097/",
                EL_SELECTOR_230BOOK);
        checkList.add(vo5);

        NovelVO vo6 = new NovelVO(6, "沧元图",
                "http://m.biqugexs.com/22_22904/",
                EL_SELECTOR_BIQUGEXS);
        checkList.add(vo6);

        return checkList;
    }

    private void checkOne(NovelVO vo) throws Exception {
        Document doc = Jsoup.connect(vo.getUrl()).get();
        Elements element = doc.select(vo.getElSelector());
        vo.setResultHtml(element.outerHtml());
    }

}
