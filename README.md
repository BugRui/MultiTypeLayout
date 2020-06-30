
# MultiTypeLayout [![version](https://jitpack.io/v/BugRui/MultiTypeLayout.svg)](https://jitpack.io/#BugRui/MultiTypeLayout/1.0.0)

多类型布局快速切换View，支持内容视图，加载中视图，空视图，异常视图，无网络视图，Multi-type layout quick switch View, support content View, load View, empty View, exception View, no network View

#### Step 1. Add the JitPack repository to your build file
```
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}

```
####  Step 2. Add the dependency
```
   implementation 'com.github.BugRui:MultiTypeLayout:1.0.0''
 
```
因为MultiTypeLayout只在内部使用compileOnly，并且依赖于appCompat，所以需要将以下依赖项添加到自己的项目中，否则compileOnly将无法通过打包

Because MultiTypeLayout only USES compileOnly internally and relies on appCompat, you need to add the following dependencies to your project otherwise compileOnly will not pass

```
 implementation "androidx.appcompat:appcompat:tag"
```

### 使用(use)

#### 在Xml中配置 Configure in Xml
```
<com.bugrui.library.MultiTypeLayout
        android:id="@+id/multiTypeLayout"
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:layout_weight="1"
        app:contentLayout="@layout/layout_content"
        app:emptyLayout="@layout/layout_empty"
        app:errorLayout="@layout/layout_error"
        app:loadingLayout="@layout/layout_loading"
        app:noNetworkLayout="@layout/layout_no_network" />

```

#### 自身配置 Its configuration

```


```
