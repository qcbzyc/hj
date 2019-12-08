//上传视频
function uploadVideo() {
  var me = this;
  wx.chooseVideo({
    sourceType: ['album'],
    success(res) {
      console.log(res);
      var duration = res.duration;
      var tmpHeight = res.height;
      var tmpWidth = res.width;
      //临时视频
      var tmpVideoUrl = res.tempFilePath;
      //临时封面
      var tmpCoverUrl = res.thumbTempFilePath;

      if (duration > 60) {
        wx.showToast({
          title: '视频长度不能超过60秒...',
          icon: "none",
          duration: 2500
        })
      } else if (duration < 3) {
        wx.showToast({
          title: '视频长度不能小于3秒...',
          icon: "none",
          duration: 2500
        })
      } else {
        //打开选择bgm界面
        wx.navigateTo({
          url: '../chooseBgm/chooseBgm?duration=' + duration +
            "&tmpHeight=" + tmpHeight +
            "&tmpWidth=" + tmpWidth +
            "&tmpVideoUrl=" + tmpVideoUrl +
            "&tmpCoverUrl=" + tmpCoverUrl,
        })
      }

    }
  })
}

module.exports = {
  uploadVideo: uploadVideo
}