var videoUtil = require('../../utils/videoUtil.js')
const app = getApp()

Page({
  data: {
    faceUrl: "../resource/images/noneface.png",

  },

  onLoad: function () {
    var me = this;
    //var user = app.userInfo;
    //fixme 修改原有的全局对象为本地缓存
    var user = app.getGlobalUserInfo();
    console.log(user.id);
    var serverUrl = app.serverUrl;
    wx.showLoading({
      title: '请等待...',
    });

    wx.request({
      url: serverUrl+'/user/query?userId='+user.id,
      method:"POST",
      header: {
        'content-type': 'application/json' // 默认值
      },
      success: function (res) {
        console.log(res.data);
        wx.hideLoading();
        if (res.data.status == 200) {
          var userInfo = res.data.data;
          var faceUrl = "../resource/images/noneface.png";
          if (userInfo.faceImage != null && userInfo.faceImage != '' &&
            userInfo.faceImage != undefined){
            faceUrl = serverUrl + userInfo.faceImage;
            }
          
          me.setData({
            faceUrl:faceUrl,
            fansCounts:userInfo.fansCounts,
            followCounts:userInfo.followCounts,
            receiveLikeCounts:userInfo.receiveLikeCounts,
            nickname:userInfo.nickname
          });
        } 
        }
    })

  },

  logout:function(){
    //var user = app.userInfo;
    //fixme 修改原有的全局对象为本地缓存
    var user = app.getGlobalUserInfo();
    var serverUrl = app.serverUrl;
    wx.showLoading({
      title: '请等待...',
    });
    // 调用后端
    wx.request({
      url: serverUrl + '/logout?userId='+user.id,
      method: "POST",
      header: {
        'content-type': 'application/json' // 默认值
      },
      success: function (res) {
        console.log(res.data);
        wx.hideLoading();
        if (res.data.status == 200) {
         //注销成功跳转
         wx.showToast({
           title: '注销成功',
           icon:'success',
           duration:2000
         });
         //销毁全局对象
         //app.userInfo=null;
         //注销之后，清空缓存
         wx.removeStorageSync("userInfo");
         //回到登录
         wx.navigateTo({
           url: '../userLogin/login',
         })
        } 
      }
    })
  },

//更换头像
  changeFace:function (){
    var me = this;
    wx.chooseImage({
     
      count: 1,
      sizeType: ['compressed'],
      sourceType: ['album'],
      success:function(res) {
        // tempFilePath可以作为img标签的src属性显示图片
        var tempFilePaths = res.tempFilePaths;
        console.log(tempFilePaths);
        wx.showLoading({
          title: '上传中...',
        });
        var serverUrl = app.serverUrl;
        //fixme 修改原有的全局对象为本地缓存
        var userInfo = app.getGlobalUserInfo();
        //上传图片
        wx.uploadFile({
          url: serverUrl + '/user/uploadFace?userId='+userInfo.id, 
          filePath: tempFilePaths[0],
          name: 'file',
          header: {
            'content-type': 'application/json' // 默认值
          },
          success(res) {
            var data = JSON.parse(res.data);
            console.log(data);
            wx.hideLoading();
            if (data.status == 200){
              wx.showToast({
                title: '上传成功！~~',
                icon: "success"
              });

              var imageUrl = data.data;
              me.setData({
                faceUrl:serverUrl+imageUrl
              });
            } else if (data.status == 500){
              wx.showToast({
                title: data.msg
              })

            }
           
          }
        })
      }
    })
  },

  //上传视频
  uploadVideo:function(){
    // fixme 视频上传复用
    // videoUtil.uploadVideo();
    // 以下是原来的代码，不删除，便于参照
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

        if(duration > 60){
          wx.showToast({
            title: '视频长度不能超过60秒...',
            icon:"none",
            duration:2500
          })
        } else if (duration < 3){
          wx.showToast({
            title: '视频长度不能小于3秒...',
            icon: "none",
            duration: 2500
          })
        }else{
          //打开选择bgm界面
          wx.navigateTo({
            url: '../chooseBgm/chooseBgm?duration=' + duration
              + "&tmpHeight=" + tmpHeight
              + "&tmpWidth=" + tmpWidth
              + "&tmpVideoUrl=" + tmpVideoUrl
              + "&tmpCoverUrl=" + tmpCoverUrl,
          })
        }
       
      }
    })
  }

})
