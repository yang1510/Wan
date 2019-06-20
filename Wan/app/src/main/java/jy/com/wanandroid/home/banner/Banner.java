package jy.com.wanandroid.home.banner;

import java.util.ArrayList;
import java.util.List;

/*
 * created by taofu on 2019-06-18
 **/
public class Banner {

    private String imgUrl;

    private String title;


    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Banner(String imgUrl, String title) {
        this.imgUrl = imgUrl;
        this.title = title;
    }

    public static List<Banner> getBanners(){

        ArrayList<Banner> banners = new ArrayList<>();

        Banner banner =new Banner("https://www.wanandroid.com/blogimgs/50c115c2-cf6c-4802-aa7b-a4334de444cd.png", "一起来做个App吧");
        banners.add(banner);


        banner = new Banner("https://www.wanandroid.com/blogimgs/ab17e8f9-6b79-450b-8079-0f2287eb6f0f.png", "看看别人的面经，搞定面试~");
        banners.add(banner);

        banner = new Banner("https://www.wanandroid.com/blogimgs/fb0ea461-e00a-482b-814f-4faca5761427.png", "兄弟，要不要挑个项目学习下?");
        banners.add(banner);

        banner = new Banner("https://www.wanandroid.com/blogimgs/62c1bd68-b5f3-4a3c-a649-7ca8c7dfabe6.png", "我们新增了一个常用导航Tab~");
        banners.add(banner);

        banner = new Banner("https://www.wanandroid.com/blogimgs/00f83f1d-3c50-439f-b705-54a49fc3d90d.jpg", "公众号文章列表强势上线");


        banners.add(banner);



        return  banners;
    }
}
