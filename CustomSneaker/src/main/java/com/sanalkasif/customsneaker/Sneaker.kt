package com.sanalkasif.customsneaker

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.github.florent37.viewanimator.ViewAnimator
import com.irozon.sneaker.Sneaker

class Sneaker private constructor(builder: Builder) {

    private var layout: Int? = null
    private var activity: Activity? = null
    private var fragment: Fragment? = null
    private var viewGroup: ViewGroup? = null
    private var sneaker: Sneaker? = null
    private var title: String = ""
    private var content: String = ""
    private var iconVisible: Boolean = true
    private var duration: Int = 3000
    private var autoHide: Boolean = true
    private var buttonName: String = ""
    private var arrowIcon: Boolean = false
    private var view: View? = null
    private var listener: SneakerListener? = null
    private var animation: Boolean = true
    private var animateRepeatCount: Int = 0
    private var animateDuration: Long = 2000

    class Builder {
        private var layout: Int = 0
        private var title: String = ""
        private var content: String = ""
        private var activity: Activity? = null
        private var fragment: Fragment? = null
        private var viewGroup: ViewGroup? = null
        private var iconVisible: Boolean = true
        private var duration: Int = 3000
        private var autoHide: Boolean = true
        private var buttonName: String = ""
        private var arrowIcon: Boolean = false
        private var listener: SneakerListener? = null
        private var animation: Boolean = true
        private var animateRepeatCount: Int = 0
        private var animateDuration: Long = 2000

        fun setType(type: SneakerType) = apply {
            layout = when (type) {
                SneakerType.Success -> {
                    R.layout.success_dialog
                }
                SneakerType.Info -> {
                    R.layout.info_dialog
                }
                SneakerType.InfoError -> {
                    R.layout.info_dialog_error
                }
                SneakerType.Warning -> {
                    R.layout.warning_dialog
                }
                SneakerType.Error -> {
                    R.layout.error_dialog
                }
            }
        }

        fun setContent(content: String) = apply { this.content = content }
        fun setTitle(title: String) = apply { this.title = title }
        fun setIconVisible(iconVisible: Boolean) = apply { this.iconVisible = iconVisible }
        fun setSneakerDuration(duration: Int) = apply { this.duration = duration }
        fun setAutoHide(autoHide: Boolean) = apply { this.autoHide = autoHide }
        fun setActivity(activity: Activity) = apply { this.activity = activity }
        fun setFragment(fragment: Fragment) = apply { this.fragment = fragment }
        fun setViewGroup(viewGroup: ViewGroup) = apply { this.viewGroup = viewGroup }
        fun setButtonName(buttonName: String) = apply { this.buttonName = buttonName }
        fun setArrowIcon(arrowIcon: Boolean) = apply { this.arrowIcon = arrowIcon }
        fun setButtonIconListener(listener: SneakerListener) = apply { this.listener = listener }
        fun setAnimation(animation: Boolean) = apply { this.animation = animation }
        fun setAnimationRepeatCount(animateRepeatCount: Int) = apply { this.animateRepeatCount = animateRepeatCount }
        fun setAnimateDuration(setAnimateDurationMS: Long) = apply { this.animateDuration = setAnimateDurationMS }


        fun build() = Sneaker(this)
        fun getIconVisible(): Boolean {
            return iconVisible
        }

        fun getType(): Int {
            return layout
        }

        fun getTitle(): String {
            return title
        }

        fun getContent(): String {
            return content
        }

        fun getActivity(): Activity? {
            return activity
        }

        fun getFragment(): Fragment? {
            return fragment
        }

        fun getViewGroup(): ViewGroup? {
            return viewGroup
        }

        fun getDuration(): Int {
            return duration
        }

        fun getAutoHide(): Boolean {
            return autoHide
        }

        fun getButtonName(): String {
            return buttonName
        }

        fun getArrowIcon(): Boolean {
            return arrowIcon
        }

        fun getButtonIconListener(): SneakerListener? {
            return listener
        }
        fun getAnimation(): Boolean {
            return animation
        }
        fun getAnimationRepeatCount(): Int {
            return animateRepeatCount
        }
        fun getAnimateDuration(): Long {
            return animateDuration
        }
    }

    init {
        layout = builder.getType()
        title = builder.getTitle()
        content = builder.getContent()
        iconVisible = builder.getIconVisible()
        activity = builder.getActivity()
        fragment = builder.getFragment()
        viewGroup = builder.getViewGroup()
        duration = builder.getDuration()
        autoHide = builder.getAutoHide()
        buttonName = builder.getButtonName()
        arrowIcon = builder.getArrowIcon()
        listener = builder.getButtonIconListener()
        animation = builder.getAnimation()
        animateRepeatCount = builder.getAnimationRepeatCount()
        animateDuration = builder.getAnimateDuration()

        if (activity != null) {
            sneaker = Sneaker.with(activity!!).autoHide(autoHide).setDuration(duration)
            view = LayoutInflater.from(activity!!).inflate(layout!!, sneaker?.getView(), false)
            view?.bringToFront()
            sneaker!!.sneakCustom(view!!)
        } else if (viewGroup != null) {
            sneaker = Sneaker.with(viewGroup!!).autoHide(autoHide).setDuration(duration)
            view = LayoutInflater.from(viewGroup!!.context)
                .inflate(layout!!, sneaker?.getView(), false)
            view?.bringToFront()
            sneaker!!.sneakCustom(view!!)
        } else if (fragment != null) {
            sneaker = Sneaker.with(fragment!!).autoHide(autoHide).setDuration(duration)
            view =
                LayoutInflater.from(fragment!!.context).inflate(layout!!, sneaker?.getView(), false)
            view?.bringToFront()
            sneaker!!.sneakCustom(view!!)
        }
        initUi()
    }

    private fun initUi() {
        val icon = view?.findViewById<ImageView>(R.id.icon)
        val buttonNameTextView = view?.findViewById<TextView>(R.id.buttonName)
        val titleTextView = view?.findViewById<TextView>(R.id.title)
        val contentTextView = view?.findViewById<TextView>(R.id.content)
        val cancelIcon = view?.findViewById<ImageView>(R.id.cancel)
        val buttonIcon = view?.findViewById<ImageView>(R.id.buttonIcon)

        titleTextView?.text = title
        contentTextView?.text = content
        buttonNameTextView?.text = buttonName
        if (listener != null) {
            buttonIcon?.setOnClickListener {
                listener?.onClickListener()
                sneaker?.hide()
            }
        }

        cancelIcon?.setOnClickListener {
            sneaker?.hide()
        }
        if (!iconVisible) {
            icon?.visibility = View.INVISIBLE
        }
        if (!arrowIcon){
            buttonIcon?.visibility = View.GONE
        }
        if (animation){
            ViewAnimator
                .animate(icon)
                .scale(1f, 0.1f, 1f)
                .repeatCount(animateRepeatCount)
                .duration(animateDuration)
                .start()

            ViewAnimator
                .animate(buttonIcon)
                .scale(0f, 1f)
                .duration(1000)
                .start()

            ViewAnimator
                .animate(titleTextView)
                .scale(0f, 1f)
                .duration(1000)
                .start()

            ViewAnimator
                .animate(contentTextView)
                .scale(0f, 1f)
                .duration(1000)
                .start()

            ViewAnimator
                .animate(cancelIcon)
                .scale(0f, 1f)
                .duration(1000)
                .start()

            ViewAnimator
                .animate(buttonNameTextView)
                .scale(0f, 1f)
                .duration(1000)
                .start()

        }
    }
}