package ga.mr838wind.checkNovel.check;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NovelVO {

    public NovelVO(int seq, String name, String url, String elSelector) {
        this.seq = seq;
        this.name = name;
        this.url = url;
        this.elSelector = elSelector;
    }

    private int seq;
    private String name;
    private String url;
    private String elSelector;

    //
    private String resultHtml;

}
