package ru.roma.vk.utilitys;

import java.util.List;

/**
 * Created by Ilan on 05.11.2017.
 */

public interface Paginable {

    List getData(int offset);
    int getCount();
}
