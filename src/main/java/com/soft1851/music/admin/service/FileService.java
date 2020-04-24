package com.soft1851.music.admin.service;

import java.util.Map;

/**
 * @author Tao
 */
public interface FileService {
    /**
     * 设置导出歌单表单表头信息
     * @return
     */
    Map<String, String> exportSongList();
}
