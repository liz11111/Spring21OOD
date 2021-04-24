04/17/2021:
Changes from last assignment:
- added implementation of getShapeAtTick() method in AnimationModelImpl
	- added getters at ticks methods in animation classes to enable getShapeAtTick()
- added setters in shape class to alter internal states of a shape

New features:
- View interface
	- Textual view: output animation as text description according to our own description rules
	- Graphics view: output animation using Swing as an animation
	- SVG view: output animation as an svg file

04/24/2021:
Changes from last assignment:
- added saveTxt feature in our textual view
- designed EditorView interface that supports showing an UI of editor
- implemented EditorView with VisualView class
- added playback as an option to command-line -view option to invoke editor view
