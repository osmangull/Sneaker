# SneakerView


 | <image src=https://user-images.githubusercontent.com/80040232/185810460-5e6c0e93-223a-41ac-97ef-56fc3b70c528.gif width="250"> | <image src=https://user-images.githubusercontent.com/80040232/185810524-f01fa6bf-ccf9-4ab4-8872-5a024082072a.gif width="250"> | <image src=https://user-images.githubusercontent.com/80040232/185810558-e5c6d8fd-e8c4-43b5-b6ec-f7699b054737.gif width="250"> |
| --- | --- | ---
 
  | <image src=https://user-images.githubusercontent.com/80040232/185810590-aa3fc607-7095-408c-a800-976222e9e2fe.gif width="250"> | <image src=https://user-images.githubusercontent.com/80040232/185810633-842b3924-59b7-44d3-8450-1331b9555668.gif width="250"> |
| --- | ---
  

## How to install ? 
You can add the library to your project using jitpack.io.

Add the code below to your project's settings.gradle file.

```
 allprojects {
        repositories {
            jcenter()
            maven { url "https://jitpack.io" }
        }
   }
```
Add the code below to your app's gradle file.
```
 implementation 'com.github.osmangull:Sneaker:1.0'

```

 # Attributes

  | Attribute | Description |
| --- | --- |
| `activity*` `fragment*` `viewGroup*`|Context is required for sneaker (by default null) | 
| `title` | Title text for sneaker (by default  "") |
| `iconVisible` | Setting icon visibility (by default true)|
| `duration` | Sneaker visibility time (by default 3000)|
| `autoHide` | Sneaker's auto-off state (by default true)|
| `buttonName`|action text for sneaker (by default  "") |
| `arrowIcon` |action icon visibility with listener (by default false) |
| `view*` |The sneaker type is selected in the SneakerType type (by default null) |
| `listener` |Assign listener for arrow icon (by default null) |
| `animation` |turn animations off and on (by default true) |
| `animateRepeatCount` |number of animation repeats (by default 0) |
| `animateDuration` |animation realization time (by default 2000) |

## Usage
 
```
 binding.success.setOnClickListener {
            Sneaker.Builder()
                .setActivity(this) /* optionally, these -> .setFragment() .setViewGroup() */
                .setType(SneakerType.Success)
                .setTitle("Success")
                .setSneakerDuration(3000)
                .setContent("Your transaction was successful")
                .setIconVisible(true)
                .setAnimateDuration(1000)
                .setAnimationRepeatCount(3)
                .setArrowIcon(true)
                .setButtonName("Action")
                .setAutoHide(false)
                .setArrowIcon(true)
                .setAnimation(true)
                .setButtonIconListener(object : SneakerListener {
                    override fun onClickListener() {
                        //TODO work to do
                    }
                })
                .build()
```
 
 ## Libraries and resources used
 https://github.com/Hamadakram/Sneaker
 
 https://github.com/florent37/ViewAnimator


##  Developed By 


 
  <img src="https://user-images.githubusercontent.com/80040232/185884317-d418f18f-b8b1-44a1-90c5-d3f456d6ae0b.png" width="70" align="left">


**Osman Gül**

[![Linkedin](https://img.shields.io/badge/-linkedin-grey?logo=linkedin)](https://www.linkedin.com/in/osmangull/)

 <img src="https://user-images.githubusercontent.com/80040232/185811123-c8f24d5b-134f-4bc3-aa2e-7a033901bc4d.png" width="70" align="left">


**Furkan Akalın**

[![Linkedin](https://img.shields.io/badge/-linkedin-grey?logo=linkedin)](https://www.linkedin.com/in/furkan-akalin/)

