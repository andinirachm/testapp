package id.testapp.presenter;

import java.util.ArrayList;
import java.util.List;

import id.testapp.model.CityModel;
import id.testapp.view.HomeView;

public class HomePresenter implements BasePresenter<HomeView> {
    private HomeView view;

    public void createDummyData() {
        List<CityModel> cityList = new ArrayList<>();
        cityList.add(new CityModel(1, "New York", "https://blogmedia.evbstatic.com/wp-content/uploads/rally/2017/12/18072307/twenty20_70fc02a0-c467-4ad1-9f08-793bbb9316bb-1500x750.jpg"));
        cityList.add(new CityModel(2, "Greece", "https://photos.gttwl.net/original/gttwl/attachments/global/1526583064_original.jpeg"));
        cityList.add(new CityModel(3, "England", "http://cdn2.tstatic.net/travel/foto/bank/images/keukenhof_20180223_091028.jpg"));
        cityList.add(new CityModel(4, "Germany", "http://www.nationsonline.org/gallery/Germany/Reichstag-Parliament-Berlin.jpg"));
        cityList.add(new CityModel(5, "Indonesia", "https://ngetrip.net/wp-content/uploads/2018/02/Labuan-Bajo-Pulau-Komodo-Pulau-Kanawa.jpg"));

        view.onCreateDummyData(cityList);
    }

    @Override
    public void onAttachView(HomeView view) {
        this.view = view;
    }

    @Override
    public void onDetachView() {
        this.view = null;
    }
}
