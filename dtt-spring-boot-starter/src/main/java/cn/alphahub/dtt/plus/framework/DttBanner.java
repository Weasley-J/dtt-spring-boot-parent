package cn.alphahub.dtt.plus.framework;

import org.apache.commons.lang3.StringUtils;

/**
 * Dtt Banner Text
 *
 * @author weasley
 * @version 1.0
 */
public final class DttBanner {

    private DttBanner() {
    }

    public static DttBanner getInstance() {
        return BannerHolder.INSTANCE;
    }

    public void printBanner() {
        String versionText = StringUtils.defaultIfBlank(DttVersion.getVersion(), "");
        if (StringUtils.isNotBlank(versionText))
            versionText = "Dtt Version: (v" + versionText + ")";
        String bannerText = "\n" +
                "__/\\\\\\\\\\\\\\\\\\\\\\\\_____/\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\__/\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\_        \n" +
                " _\\/\\\\\\////////\\\\\\__\\///////\\\\\\/////__\\///////\\\\\\/////__        \n" +
                "  _\\/\\\\\\______\\//\\\\\\_______\\/\\\\\\_____________\\/\\\\\\_______      \n" +
                "   _\\/\\\\\\_______\\/\\\\\\_______\\/\\\\\\_____________\\/\\\\\\_______     \n" +
                "    _\\/\\\\\\_______\\/\\\\\\_______\\/\\\\\\_____________\\/\\\\\\_______    \n" +
                "     _\\/\\\\\\_______\\/\\\\\\_______\\/\\\\\\_____________\\/\\\\\\_______   \n" +
                "      _\\/\\\\\\_______/\\\\\\________\\/\\\\\\_____________\\/\\\\\\_______   \n" +
                "       _\\/\\\\\\\\\\\\\\\\\\\\\\\\/_________\\/\\\\\\_____________\\/\\\\\\_______ \n" +
                "        _\\////////////___________\\///______________\\///________\n" +
                "" + versionText + "\n";
        System.out.println(bannerText);
    }

    private static class BannerHolder {
        private static final DttBanner INSTANCE = new DttBanner();
    }

}
